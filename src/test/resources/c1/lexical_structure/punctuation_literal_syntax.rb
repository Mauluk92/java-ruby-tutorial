# Global variables are prefixed with a dollar sign
# Ruby defines a certain number of special global variables

$global_variable = 1

# Instance variables are marked with a single at sign (@) as prefix
# Class variables have two at sign as prefix

class AClass
  @@class_variable = 1
  @instance_variable = 1
end

# As an helpful convention, methods that returns a boolean are
# post-fixed with question mark (?)

def is_valid?
  true
end

# A method name may end with an exclamation mark (!)
# to indicate that the method should be used cautiously
# (For example a mutator method that alter the instance state)

def be_cautious!
  true
end

# A method with an equal sign at the end may be invoked
# at the left of an assignment operator

def assignment_function=
  true
end
