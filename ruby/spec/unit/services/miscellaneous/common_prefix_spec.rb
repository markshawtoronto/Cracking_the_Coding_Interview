# frozen_string_literal: true

require "spec_helper"

describe Miscellaneous::CommonPrefix do
  context "#find_common_prefix" do
    it "should handle simple strings" do
      expect(Miscellaneous::CommonPrefix.find_common_prefix(["zoo", "wordula", "wordy", "space"])). to eq "word"
    end
  end
end
