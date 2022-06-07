require "spec_helper"

describe Miscellaneous::PalindromeSubstring do
  context "#longest_palindrome" do
    it "should return a regular palindrome" do
      expect(Miscellaneous::PalindromeSubstring::longest_palindrome("racecar")).to eq "racecar"
    end

    it "should handle an even word like aba" do
      expect(Miscellaneous::PalindromeSubstring::longest_palindrome("aba")).to eq "aba"
    end

    it "should handle an odd work like abba" do
      expect(Miscellaneous::PalindromeSubstring::longest_palindrome("abba")).to eq "abba"
    end
  end
end