describe Chapter1::Problem1 do
  context "#solve" do
    it "should handle strings with no repeat characters" do
      expect(Chapter1::Problem1.solve("asdf")).to eq true
    end

    it "should handle strings with repeat characters" do
      expect(Chapter1::Problem1.solve("aanfd")).to eq false
    end
  end
end
