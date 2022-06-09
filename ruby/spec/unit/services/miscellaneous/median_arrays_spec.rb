# frozen_string_literal: true

require "spec_helper"

describe Miscellaneous::MedianArrays do
  context "#find_median_sorted_arrays" do
    it "should handle short odd arrays" do
      nums1 = [1, 3]
      nums2 = [2]

      expect(Miscellaneous::MedianArrays.find_median_sorted_arrays(nums1, nums2)). to eq 2
    end

    it "should handle longer odd arrays" do
      nums1 = [1, 3, 5, 6, 7]
      nums2 = [2, 10]

      expect(Miscellaneous::MedianArrays.find_median_sorted_arrays(nums1, nums2)). to eq 5
    end

    it "should handle even arrays" do
      nums1 = [1, 3, 5, 6, 7]
      nums2 = [2, 10, 12]

      expect(Miscellaneous::MedianArrays.find_median_sorted_arrays(nums1, nums2)). to eq 5.5
    end

    it "should handle arrays where all nums1 < nums2 cases" do
      nums1 = [1, 2]
      nums2 = [3, 4]

      expect(Miscellaneous::MedianArrays.find_median_sorted_arrays(nums1, nums2)). to eq 2.5
    end

    it "should handle empty nums2" do
      nums1 = [2]
      nums2 = []

      expect(Miscellaneous::MedianArrays.find_median_sorted_arrays(nums1, nums2)). to eq 2
    end

    it "should handle empty nums1" do
      nums1 = []
      nums2 = [1, 2, 4]

      expect(Miscellaneous::MedianArrays.find_median_sorted_arrays(nums1, nums2)). to eq 2
    end

    it "should handle very short input" do
      nums1 = [100001]
      nums2 = [100000]

      expect(Miscellaneous::MedianArrays.find_median_sorted_arrays(nums1, nums2)). to eq 100000.5
    end
  end
end
