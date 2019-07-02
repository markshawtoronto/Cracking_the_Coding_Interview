<?php

/**
 * Class ArraysAndStrings
 *
 * Determine if a string has all unique characters.
 */
class ArraysAndStrings {

    public function hasUniqueCharacters(string $word) : bool {
        $letter_map = [];
        for ($i = 0; $i < strlen($word); $i++) {
            $letter = $word[$i];
            if (isset($letter_map[$letter])) {
                return false;
            }
            $letter_map[$word] = true;
        }

        return true;
    }
}

class ArraysAndStringsTest extends \PHPUnit_Framework_TestCase {

    const car_type = "car";

    protected $solver;

    /**
     * @test
     * @dataProvider getWords
     * @param $word
     */
    public function wordsData($word) {
        $this->solver = new ArraysAndStrings();
        $this->assertEquals($this->solver->hasUniqueCharacters($word), true);
    }

    public function getWords() {
        return [
            'Normal' => ['abcdefg'],
            'Empty' => ['']
        ];
    }
}