package shop.mtcoding.springblogriver._core.util;

import shop.mtcoding.springblogriver._core.error.exception.Exception400;

public class AssertTest {

    //@Test
    public void true_test(){
        assert 1==1; throw new Exception400("true 일때 오류 발생");
    }
}
