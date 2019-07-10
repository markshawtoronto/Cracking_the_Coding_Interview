describe Chapter1::Problem3 do
  context "#solve" do
    it "should handle when one string is a permutation of the other" do
      expect(Chapter1::Problem3.solve("and", "dan")).to eq true
    end

    it "should handle when one string has an additional character" do
      expect(Chapter1::Problem3.solve("and", "band")).to eq false
    end

    it "should handle when both strings have different characters" do
      expect(Chapter1::Problem3.solve("and", "any")).to eq false
    end
  end
end
