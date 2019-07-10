# Given two strings, write a method to decide if one is a permutation of the other.

module Chapter1
  module Problem3
    extend self

    def solve(string1, string2)
      character_count = {}

      string1.chars.each do |char|
        character_count[char] = 0 if character_count[char].nil?
        character_count[char] += 1
      end
      string2.chars.each do |char|
        if character_count[char].nil?
          return false
        end
        character_count[char] -= 1
      end

      character_count.each do |char, count|
        if count != 0
          return false
        end
      end

      true
    end
  end
end
