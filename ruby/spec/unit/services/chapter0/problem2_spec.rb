describe Chapter0::Problem2 do
  context "#solve" do
    it "should handle odd size arrays" do
      expect(Chapter0::Problem2.solve([3, 4, 5, 6, 7, 1, 2])).to eq 1
    end

    it "should handle even size arrays" do
      expect(Chapter0::Problem2.solve([5, 6, 2, 3, 4, 5])).to eq 2
    end

    it "should handle barely resorted arrays on the left" do
      expect(Chapter0::Problem2.solve([8, 2, 3, 4, 5, 6, 7])).to eq 2
    end

    it "should handle barely resorted arrays on the right" do
      expect(Chapter0::Problem2.solve([2, 3, 4, 5, 6, 7, 1])).to eq 1
    end
  end
end
