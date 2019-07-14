describe Chapter11::Problem2 do
  describe "#solve" do
    it "should handle arrays with a few anagrams" do
      expect(described_class.solve(["glass", "butterfly", "slags", "futterbly"])).to eq ["glass", "slags", "butterfly", "futterbly"]
    end

    it "should not sort arrays with no anagrams" do
      expect(described_class.solve(["glass", "cucumber", "ruffles", "pineapple"])).to eq ["glass", "cucumber", "ruffles", "pineapple"]
    end
  end
end
