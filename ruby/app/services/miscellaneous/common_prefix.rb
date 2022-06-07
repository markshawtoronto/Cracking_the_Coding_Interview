# Given a list of words, find the maximum common prefix between any two words in the input list

module Miscellaneous
  module CommonPrefix
    extend self

    def find_common_prefix(input)
      global_max_length = 0
      global_max_prefix = ""

      # Alphabetize, to make fewer comparisons
      input.sort!

      # Compare each word only with its neighbour
      (0..input.length-2).each do |i|
        word_1 = input[i]
        word_2 = input[i+1]

        length = find_common_prefix_length(word_1, word_2)
        if length > global_max_length
          global_max_length = length
          global_max_prefix = word_1[0..length-1]
        end
      end

      global_max_prefix
    end

    # Find the common prefix length for two words
    def find_common_prefix_length(a, b)
      length = 0
      while (a[length] == b[length])
        length += 1
      end

      length
    end
  end
end
