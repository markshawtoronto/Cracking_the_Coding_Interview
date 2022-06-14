describe Miscellaneous::ValidParenthesis do
  describe "#problem" do
    it "should handle a single valid bracket" do
      expect(Miscellaneous::ValidParenthesis.is_valid("()")).to eq true
    end

    it "should fail on a single valid bracket" do
      expect(Miscellaneous::ValidParenthesis.is_valid("(")).to eq false
    end

    it "should handle many valid brackets" do
      expect(Miscellaneous::ValidParenthesis.is_valid("([{}])")).to eq true
    end

    it "should handle many invalid brackets" do
      expect(Miscellaneous::ValidParenthesis.is_valid("([{])")).to eq false
    end

    it "should handle order" do
      expect(Miscellaneous::ValidParenthesis.is_valid("([)]")).to eq false
    end
  end
end
