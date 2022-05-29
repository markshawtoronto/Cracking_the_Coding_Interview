# frozen_string_literal: true

require "spec_helper"

describe Miscellaneous::TwoSum do
  context "#find_pairs_for" do
    it "should return the correct pairs for 2" do
      expect(Miscellaneous::TwoSum.find_pairs_for(2)).to eq([[1, 1]])
    end

    it "should return the correct pairs for 10" do
      expect(Miscellaneous::TwoSum.find_pairs_for(10)).to eq([[1, 9], [2, 8], [3, 7], [4, 6], [5, 5]])
    end

    it "should return this correct pairs for 11" do
      expect(Miscellaneous::TwoSum.find_pairs_for(11)).to eq([[1, 10], [2, 9], [3, 8], [4, 7], [5, 6]])
    end
  end

  context "#two_sum_problem" do
    it "should return the correct pair for the simplest array" do
      expect(Miscellaneous::TwoSum.two_sum_problem([100, 0], 100)).to eq([0, 1])
    end

    it "should return the correct pair when there is more than one element in the array" do
      expect(Miscellaneous::TwoSum.two_sum_problem([100, 99, 44, 12, 0], 100)).to eq([0, 4])
    end

    it "should return the correct pair when there are tricks" do
      expect(Miscellaneous::TwoSum.two_sum_problem([3, 2, 4], 6)).to eq([1, 2])
    end
  end
end
