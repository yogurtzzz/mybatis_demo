package com.yogurt.po;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentExt{

	private Integer id;

	private String name;

	private Integer score;

	private Integer age;

	private Integer gender;

	private Clazz clazz;

}
