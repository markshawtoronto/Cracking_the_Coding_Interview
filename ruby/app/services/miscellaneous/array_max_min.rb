module Miscellaneous
  module ArrayMaxMin
    extend self

    # Given an array of numbers, find the minimum value of the absolute difference that can be obtained from any pair of numbers from the array.
    def find_min(array)
      min_difference = nil
      for i in 0..array.length - 1 do
        for j in i + 1..array.length - 1 do
          difference = (array[i] - array[j]).abs
          if min_difference.nil? || difference < min_difference
            min_difference = difference
          end
        end
      end
      min_difference
    end

    # Given an array of numbers, find the maximum value of the absolute difference that can be obtained from any pair of numbers from the array.
    def find_max(array)
      max_difference = 0
      for i in 0..array.length - 1 do
        for j in i + 1..array.length - 1 do
          difference = (array[i] - array[j]).abs
          if difference > max_difference
            max_difference = difference
          end
        end
      end
      max_difference
    end
  end
end
