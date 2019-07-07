describe Chapter0::Problem5 do
  context "#append_to_array" do

    before :each do
      @solver = Chapter0::Problem5.new
    end

    it "should append a number to an array of numbers" do
      expect(@solver.append_to_array(5)).to eq [5]
      expect(@solver.append_to_array(3)).to eq [5, 3]
      expect(@solver.append_to_array(2)).to eq [5, 3, 2]
      expect(@solver.append_to_array(0)).to eq [5, 3, 2, 0]
    end

    it "should track the median" do
      expect(@solver.append_to_array(3)).to eq [3]
      expect(@solver.median).to eq 3
      expect(@solver.append_to_array(5)).to eq [3, 5]
      expect(@solver.median).to eq 4
      expect(@solver.append_to_array(2)).to eq [3, 5, 2]
      expect(@solver.median).to eq 3
      expect(@solver.append_to_array(0)).to eq [3, 5, 2, 0]
      expect(@solver.median).to eq 2.5
    end
  end
end
