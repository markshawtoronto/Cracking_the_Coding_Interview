# Given two sorted arrays, find the median of the combined array
# But do it in (m + n) Big O optimization

module Miscellaneous
  module MedianArrays
    extend self

    # @param {Integer[]} nums1
    # @param {Integer[]} nums2
    # @return {Float}
    def find_median_sorted_arrays(nums1, nums2)

      x = 0
      y = 0
      combined_array = []
      midpoint = (nums1.size + nums2.size) / 2

      # Move two pointers across the sorted arrays
      while x + y <= midpoint do
        if nums2.empty? || nums2[y].nil? || !nums1[x].nil? && nums1[x] <= nums2[y]
          combined_array.append(nums1[x])
          x += 1
        else
          combined_array.append(nums2[y])
          y += 1
        end
      end

      if (nums1.size + nums2.size).even?
        (combined_array.last.to_f + combined_array[-2].to_f) / 2
      else
        combined_array.last
      end
    end
  end
end