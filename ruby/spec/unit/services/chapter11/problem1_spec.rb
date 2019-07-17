describe Chapter11::Problem1 do
  describe "#solve" do
    it "should resolve basic cases" do
      a = [1, 2, 3, 4, 5, 6, 7]
      b = [2, 3, 3, 4, 5, 6]
      expect(Chapter11::Problem1.solve(a, b)).to eq [1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7]
    end

    it "should resolve all identical numbers" do
      a = [1, 1, 1, 1, 1, 1, 1]
      b = [1, 1, 1, 1, 1, 1, 1]
      expect(Chapter11::Problem1.solve(a, b)).to eq [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    end
  end
end
