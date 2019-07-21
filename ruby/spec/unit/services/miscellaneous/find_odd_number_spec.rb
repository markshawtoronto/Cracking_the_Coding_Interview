describe Miscellaneous::FindOddNumber do
  describe "#solve" do
    it "should find the one odd number in the array" do
      expect(Miscellaneous::FindOddNumber.solve([1, 1, 3, 3, 3, 5, 5, 4, 4, 2, 2])).to eq 3
    end
  end
end
