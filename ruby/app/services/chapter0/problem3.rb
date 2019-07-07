# Determine if a string can be formed from the characters in a given magazine.

module Chapter0
  module Problem3
    extend self

    def solve(magazine, ransom_note)
      character_count = {}
      magazine.split("").each do |char|
        character_count[char] = 0 if character_count[char].nil?
        character_count[char] += 1
      end

      ransom_note.split("").each do |char|
        return false if character_count[char].nil?

        character_count[char] -= 1

        return false if character_count[char] < 0
      end

      true
    end
  end
end
