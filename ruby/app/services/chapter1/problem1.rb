# Implement an algorithm to determine if a string has all unique characters.

module Chapter1
  module Problem1
    extend self

    def solve(input)
      character_count = {}
      input.chars.each do |char|
        character_count[char] = 0 if character_count[char].nil?
        character_count[char] += 1
        if character_count[char] > 1
          return false
        end
      end

      true
    end
  end
end
