<?php

/**
 * Class Solver
 *
 * A sorted array has been spliced at one point.
 * Find the minimum value in the array.
 * You may assume all elements are unique.
 */
class Solver {

    protected $array;

    public function __construct($data) {
        $this->array = $data;
    }

    public function search() {
        $length = count($this->array);
        $mid = ceil($length / 2) - 1;
        $end = $length - 1;

        if (count($this->array) === 1) {
            return $this->array[0];
        } elseif (count($this->array) === 2) {
            if ($this->array[0] > $this->array[1]) {
                return $this->array[1];
            } else {
                return $this->array[0];
            }
        }

        if ($this->array[$end] < $this->array[$mid]) {
            $this->array = array_slice($this->array, $mid, $end);
        } else {
            $this->array = array_slice($this->array, 0, $mid + 1);
        }
        return $this->search();
    }
}

class SolverTest extends \PHPUnit_Framework_TestCase {

    protected $solver;

    /**
     * @test
     * @param $data
     * @dataProvider searchTestData
     */
    public function searchTest($data) {
        $this->solver = new Solver($data);
        $min = $this->solver->search();
        $this->assertEquals($min, min($data));
    }

    public function searchTestData() {
        return [
            'textbook' => [[3, 4, 5, 6, 7, 1, 2]],
            'unaltered' => [[1, 2, 3, 4, 5, 6, 7]],
            'short' => [[1, 2]],
            'shorter' => [[2]]
        ];
    }
}