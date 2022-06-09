describe Miscellaneous::PalindromeInteger do
  describe "#is_palindrome" do
    it "should parse simple palindrome" do
      expect(Miscellaneous::PalindromeInteger.is_palindrome(121)).to eq true
    end

    it "should reject negative integers" do
      expect(Miscellaneous::PalindromeInteger.is_palindrome(-121)).to eq false
    end

    it "should parse non palindrome" do
      expect(Miscellaneous::PalindromeInteger.is_palindrome(1271)).to eq false
    end
  end
end