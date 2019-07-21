# Given an array of n integers find the number which is repeated an odd number of times. There is only one such number.

module Miscellaneous
  module FindOddNumber
    extend self

    def solve(input)
      counts = {}
      odd_number = nil
      input.each do |value|
        counts[value] ||= 0
        counts[value] += 1
      end
      counts.each do |key, value|
        if value.odd?
          odd_number = key
        end
      end

      odd_number
    end
  end
end
