package com.aaa.rong.emp;


public class Account {

  private long id;
  private String name;
  private double money;

  public Account(long id, String name, double money) {
    this.id = id;
    this.name = name;
    this.money = money;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

}
