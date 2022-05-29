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
    #
    # ## O(n)log(n)
    # ## Create a hash
    # ## Move one pointer and lookup if target is in the hash
    def self.two_sum_problem(array, sum)
      hash = {}
      nums.each_with_index do |num, i|
        hash[num] = i
      end

      nums.each_with_index do |num, i|
        if hash[target - num] != nil && hash[target - num] != i
          return [i, hash[target - num]]
        end
      end
    end
  end
end
