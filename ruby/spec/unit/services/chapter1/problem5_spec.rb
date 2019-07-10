describe Chapter1::Problem5 do
  context "#solve" do
    it "should compress short strings" do
      expect(Chapter1::Problem5.solve("aabcccccaaa")).to eq "a2b1c5a3"
    end

    it "should return the original string if it's shorter than the compressed string" do
      expect(Chapter1::Problem5.solve("ab")).to eq "ab"
    end
  end
end
