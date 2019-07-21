describe Miscellaneous::ArrayMaxMin do
  describe "#find_min" do
    it "should find the minimum absolute value difference" do
      expect(Miscellaneous::ArrayMaxMin.find_min([-2, 0, 2, 3, 5, 7, 9, 12])).to eq 1
    end
  end

  describe "#find_max" do
    it "should find the maximum absolute value difference" do
      expect(Miscellaneous::ArrayMaxMin.find_max([-2, 0, 2, 3, 5, 7, 9, 12])).to eq 14
    end
  end
end
