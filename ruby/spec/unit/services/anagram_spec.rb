# frozen_string_literal: true

require "spec_helper"

describe Anagram do
  context "#make_anagram" do
    it "should handle simple strings" do
      a = "zhra"
      b = "bceaa"

      expect(Anagram.make_anagram(a, b)). to eq 7
    end
  end
end
