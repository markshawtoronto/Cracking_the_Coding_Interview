describe Miscellaneous::Palindrome do
  describe "#first_palindrome" do
    it "should parse simple arrays" do
      expect(Miscellaneous::Palindrome.first_palindrome(["test", "ada", "mac"])).to eq "ada"
    end

    it "should handle two palindromes" do
      expect(Miscellaneous::Palindrome.first_palindrome(["racecar", "ada", "test"])).to eq "racecar"
    end
  end
end