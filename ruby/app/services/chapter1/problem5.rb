# Write a method to perform basic string compression using the counts of repeated characters.
# For example, the string aabcccccaaa would become a2b1c5a3
# If the "compressed" string is smaller than the original string, your method should return the original string.
# You can assume the string has only upper and lower case letters (a-z)

module Chapter1
  module Problem5
    extend self

    def solve(input)
      output = ""
      character_count = 0
      character_array = input.chars
      (0..character_array.length - 1).each do |i|
        character_count += 1
        if character_array[i] != character_array[i + 1] || i == character_array.length - 1
          output << "#{character_array[i]}#{character_count}"
          character_count = 0
        end
      end

      if input.length < output.length
        input
      else
        output
      end
    end
  end
end
