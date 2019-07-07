describe Chapter0::Problem4 do
  context "#solve" do
    it "should handle small arrays" do
      expect(Chapter0::Problem4.solve("ab")).to eq ["ab", "ba"]
    end

    it "should handle large arrays" do
      expect(Chapter0::Problem4.solve("abc")).to eq ["abc", "acb", "bac", "bca", "cab", "cba"]
    end
  end
end
