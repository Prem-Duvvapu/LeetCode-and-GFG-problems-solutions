# @param {Integer[]} nums
# @return {Integer}
$max_val = 0
puts "maxval #{$max_val}"
def count_max_or_subsets(nums)
    $max_val = 0
    solve(nums,0,0)
    return count(nums,0,0)
end

def solve(nums, curr, index)
    if index >= nums.length
        $max_val = [$max_val, curr].max
        return
    end
    
    #notpick
    solve(nums,curr,index+1)

    #pick
    curr |= nums[index]
    solve(nums,curr,index+1)
end

def count(nums, curr, index)
    if index >= nums.length
        if curr == $max_val
            return 1
        else
            return 0
        end
    end

    #notpick
    not_pick = count(nums,curr,index+1)

    #pick
    curr |= nums[index]
    pick = count(nums,curr,index+1)

    return not_pick + pick
end
