import { Component, OnInit, OnDestroy, Output, EventEmitter, Input } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { throttleTime } from 'rxjs';
import { ITanks } from 'src/app/interfaces/i-tanks';

@Component({
  selector: 'put-request-form',
  templateUrl: './put-form-request.component.html',
  styleUrls: ['./put-form-request.component.scss'],
})
export class PutRequestFormComponent implements OnInit, OnDestroy {
  public formGroup!: FormGroup;
  public model: ITanks = { "name": "Леклерк", "power": 1500, "power_reserve": 550, "speed": 71, "photo": "./assets/img/2.jpg" };
  @Output() public onChange: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public onInit: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public putRequest: EventEmitter<ITanks> = new EventEmitter<ITanks>();

  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.initForm();
    this.formGroup.valueChanges.subscribe(formData => {
      this.onChange.emit(this.formGroup);
    });
    this.onInit.emit(this.formGroup);
  }

  private initForm() {
    this.formGroup = this.fb.group({
      name: [
        this.model.name,
        [Validators.required,]],

      power: [
        this.model.power,
        [Validators.required,]
      ],

      power_reserve: [
        this.model.power_reserve,
        [Validators.required,]],

      speed: [
        this.model.speed,
        [Validators.required,]],

      photo: [
        this.model.photo,
        [Validators.required,]],
    });
  }
  // convenience getter for easy access to form fields
  get f(): any {
    return this.formGroup.controls;
  }

  addItem(formArrayName: string) {
    this.f[formArrayName].push(this.fb.control(''));
  }

  deleteItem(formArrayName: string, index: number) {
    this.f[formArrayName].removeAt(index);
  }
  onSubmit() {
    if (this.formGroup.invalid == false) {
      this.model.name = this.f['name'].value;
      this.model.power = this.f['power'].value;
      this.model.power_reserve = this.f['power_reserve'].value;
      this.model.speed = this.f['speed'].value;
      this.model.photo = this.f['photo'].value;
      this.putRequest.emit(this.model);
    }
  }

  ngOnDestroy() {

  }
}