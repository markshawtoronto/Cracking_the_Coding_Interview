# frozen_string_literal: true

require "spec_helper"

describe Miscellaneous::CountBrackets do
  context "#determine" do
    it "should handle ()" do
      expect(Miscellaneous::CountBrackets.determine("()")).to eq true
    end

    it "should handle (" do
      expect(Miscellaneous::CountBrackets.determine("(")).to eq false
    end

    it "should handle ) ()" do
      expect(Miscellaneous::CountBrackets.determine(") ()")).to eq false
    end

    it "should handle ((Foo) Bar)" do
      expect(Miscellaneous::CountBrackets.determine("((Foo) Bar)")).to eq true
    end

    it "should handle ((Foo) (Bar))" do
      expect(Miscellaneous::CountBrackets.determine("((Foo) (Bar))")).to eq true
    end

    it "should handle ((Foo) ) (Bar))" do
      expect(Miscellaneous::CountBrackets.determine("((Foo) ) (Bar))")).to eq false
    end
  end
end
