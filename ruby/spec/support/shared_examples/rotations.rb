shared_examples "rotations" do
  it "should handle a basic rotation" do
    expect(solution.solve("erbottlewat", "waterbottle")).to eq true
  end

  it "should reject a bad rotation" do
    expect(solution.solve("waterbottle", "botwatertle")).to eq false
  end

  it "should not get confused by letters appearing twice in a string" do
    expect(solution.solve("orld of warcraftw", "world of warcraft")).to eq true
  end
end
