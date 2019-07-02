# A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2
# How would you find the minimum element?

module Chapter0
  module Problem2
    extend self

    def solve(array)
      if array.length == 2
        return array.min
      end

      midpoint = (array.length.to_f / 2).ceil - 1

      if array.first > array[midpoint]
        solve(array[0..midpoint])
      elsif array.last < array[midpoint]
        solve(array[midpoint..array.length])
      end
    end
  end
end
