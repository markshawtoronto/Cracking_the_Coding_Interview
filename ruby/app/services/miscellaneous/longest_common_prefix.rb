# Write a function to find the longest common prefix string amongst an array of strings.

module Miscellaneous
  module LongestCommonPrefix
    extend self

    def longest_common_prefix(strs)
      longest_prefix = 0

      # Create a histogram of letter frequency
      # If only one letter found, continue to next letter
      # Otherwise, stop search and assemble string so far.
      (0..strs.first.length - 1).each do |i|
        histogram = {}
        strs.each do |s|
          character = s[i]
          if histogram[character].nil?
            histogram[character] = 1
          else
            histogram[character] += 1
          end
        end

        if histogram.size == 1
          longest_prefix += 1
        else
          break
        end
      end

      if longest_prefix == 0
        return ""
      end

      strs.first[0..longest_prefix - 1]
    end
  end
end