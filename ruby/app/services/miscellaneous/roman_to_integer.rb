# Convert a Roman Numeral to an integer

module Miscellaneous
  module RomanToInteger
    extend self

    def self.roman_to_int(s)
      map = {
        "I" => 1,
        "V" => 5,
        "X" => 10,
        "L" => 50,
        "C" => 100,
        "D" => 500,
        "M" => 1000
      }

      num = 0
      s.chars.each_with_index do |char, index|
        next_char = s.chars[index+1]
        if !next_char.nil? && map[next_char] > map[char]
          num -= map[char]
        else
          num += map[char]
        end
      end

      num
    end
  end
end