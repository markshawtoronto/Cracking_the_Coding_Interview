describe Chapter0::Problem3 do
  context "#solve" do
    it "should reject incorrect re-arrangements" do
      expect(Chapter0::Problem3.solve("hello world", "zoinks")).to eq false
    end

    it "should accept correct re-arrangements" do
      expect(Chapter0::Problem3.solve("hello world", "well oh")).to eq true
    end
  end
end
