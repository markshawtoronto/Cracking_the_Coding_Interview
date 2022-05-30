# frozen_string_literal: true

require "spec_helper"

describe Miscellaneous::AnagramVariation do
  context "#make_anagram" do
    it "should handle simple strings" do
      s = "bab"
      t = "aba"
      expect(Miscellaneous::AnagramVariation.make_anagram(s,t)).to eq 1
    end

    it "should handle long strings" do
      s = "leetcode"
      t = "practice"
      expect(Miscellaneous::AnagramVariation.make_anagram(s,t)).to eq 5
    end
  end
end
