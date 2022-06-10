# frozen_string_literal: true

require "spec_helper"

describe Miscellaneous::RomanToInteger do
  context "#roman_to_int" do
    it "should handle simple numerals" do
      expect(Miscellaneous::RomanToInteger.roman_to_int("III")).to eq 3
      expect(Miscellaneous::RomanToInteger.roman_to_int("LVIII")).to eq 58
    end

    it "should handle numerals with 4s in them" do
      expect(Miscellaneous::RomanToInteger.roman_to_int("IV")).to eq 4
      expect(Miscellaneous::RomanToInteger.roman_to_int("MCMXCIV")).to eq 1994
    end
  end
end
