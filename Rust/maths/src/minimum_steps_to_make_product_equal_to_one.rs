// Problem title: Minimum Steps to Make Product Equal to One

pub fn min_steps(arr: &[i32]) -> u32 {
    let mut neg = 0;
    let mut zero = 0;

    let mut step = 0;

    for &x in arr {
        if x < 0 {
            neg += 1;
            step += -1 - x;
        } else if x == 0 {
            zero += 1;
        } else {
            step += x - 1;
        }
    }

    if neg & 1 == 1 && zero == 0 {
        (step + 2) as u32
    } else {
        (step + zero) as u32
    }
}
