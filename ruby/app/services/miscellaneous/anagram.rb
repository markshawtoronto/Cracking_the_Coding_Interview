# Determine if two strings are anagrams of each other.

module Miscellaneous
  module Anagram
    extend self

    def make_anagram(a, b)
      anagram_subtraction = 0
      a_letter_count = letter_count_from_string(a)
      b_letter_count = letter_count_from_string(b)

      letter_differences = a_letter_count.merge(b_letter_count) do |_key, a_value, b_value|
        a_value - b_value
      end
      letter_differences.each do |_key, value|
        anagram_subtraction += value.abs
      end

      anagram_subtraction
    end

    private

    def letter_count_from_string(string)
      string_letter_count = {}
      string.split("").each do |letter|
        if string_letter_count[letter].nil?
          string_letter_count[letter] = 0
        end
        string_letter_count[letter] += 1
      end
      string_letter_count
    end
  end
end
