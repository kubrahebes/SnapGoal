package com.example.android.snapgoal.models;

public class Leagues {
private String name;
private  int counter;

 public Leagues(String name, int counter) {
  this.name = name;
  this.counter = counter;
 }

 public Leagues(int counter) {
  this.counter = counter;
 }

 public Leagues(String name) {
  this.name = name;
 }

 public Leagues() {
 }

 public int getCounter() {
  return counter;
 }

 public void setCounter(int counter) {
  this.counter = counter;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }
}
