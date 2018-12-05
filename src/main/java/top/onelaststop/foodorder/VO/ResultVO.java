package top.onelaststop.foodorder.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T>  implements Serializable {

//    private static final long serialVersionUID = ;

    private Integer code;

    private String msg;

    private T data;
}
