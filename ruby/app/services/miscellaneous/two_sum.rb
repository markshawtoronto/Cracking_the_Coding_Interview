# frozen_string_literal: true

module Miscellaneous
  class TwoSum
    # Output an array of pairs which sum up to a sum.
    def self.find_pairs_for(sum)
      pair_1 = sum
      pair_2 = 0

      output = []
      (sum / 2).ceil.times do
        pair_1 = pair_1 - 1
        pair_2 = pair_2 + 1
        output.append([pair_2, pair_1])
      end

      output
    end

    # Find which two values in an array add up to a sum.
    def self.two_sum_problem(array, sum)
      hash = {}
      array.each_with_index do |value, index|
        hash[value] = index
      end

      array.each_with_index do |value, index|
        lookup_index = hash[sum - value]
        if !lookup_index.nil? && index != lookup_index
          return [index, lookup_index]
        end
      end
    end
  end
end
