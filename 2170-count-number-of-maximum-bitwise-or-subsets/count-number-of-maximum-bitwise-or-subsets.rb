# @param {Integer[]} nums
# @return {Integer}
$max_val = 0
$list = []

def count_max_or_subsets(nums)
    $max_val = 0
    $list = []
    solve(nums,0,0)
    return $list.count($max_val)
end

def solve(nums, curr, index)
    if index >= nums.length
        $list << curr
        $max_val = [$max_val, curr].max
        return
    end
    
    #notpick
    solve(nums,curr,index+1)

    #pick
    curr |= nums[index]
    solve(nums,curr,index+1)
end
