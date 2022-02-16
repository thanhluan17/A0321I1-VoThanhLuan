import {Component, OnInit} from '@angular/core';
import {ITodo} from '../todo';
import {FormControl} from '@angular/forms';
import {TodoService} from '../service/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {
  todoList: ITodo[] = [];
  inputControl = new FormControl();

  constructor(private todoService: TodoService) {
  }

  ngOnInit() {
    this.todoService.getTodos().subscribe(next => {
      this.todoList = next;
    }, error => {
      console.log(error);
    }, () => {
      console.log('complete');
    });
  }

  toggleTodo(i) {
    const todo = this.todoList[i];
    const todoData = {
      ...todo,
      completed: !todo.completed
    };
    this.todoService.updateTodo(todoData).subscribe(next => {
      this.todoList[i].completed = next.completed;
    });
  }

  addTodo() {
    const todo: Partial<ITodo> = {
      title: this.inputControl.value,
      completed: false
    };

    this.todoService.createTodo(todo).subscribe(next => {
      this.todoList.unshift(next);
      this.inputControl.setValue('');
    });
  }

  deleteTodo(i) {
    const todo = this.todoList[i];
    this.todoService.deleteTodo(todo.id).subscribe(() => {
      this.todoList = this.todoList.filter(t => t.id !== todo.id);
    });
  }

}
