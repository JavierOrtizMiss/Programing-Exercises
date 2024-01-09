#Promedio de duración
otros_cursos_min=2.5
otros_cursos_prom=4
otros_cursos_max=7
dalto_curso=1.5

#Duración de crudos
crudo_promedio=5
crudo_dalto=3.5


#Diferencias de duración
diferencia_con_min= round(100-(dalto_curso/otros_cursos_min*100),1)
diferencia_con_prom= round(100-(dalto_curso/otros_cursos_prom*100),1)
diferencia_con_max= round(100-(dalto_curso/otros_cursos_max*100),1)

#Calculando el porcentaje de tiempo vacío
tiempo_vacio_promedio=round(100-(otros_cursos_prom/crudo_promedio*100),1)
tiempo_vacio_dalto=round(100-(dalto_curso/crudo_dalto*100),1)

#Mostrando las diferencias de duración
print(f"El curso de Dalto duran un {diferencia_con_min}% menos que el más rápido")
print(f"El curso de Dalto duran un {diferencia_con_prom}% menos que el más rápido")
print(f"El curso de Dalto duran un {diferencia_con_max}% menos que el promedio")

print("---------------------------------------------------------------------------")
#Mostrando la cantidad de espacios vacíos que se remuevem
print(f"Un curso promedio elimina un {tiempo_vacio_promedio}% de tiempo vacío")
print(f"Este curso eliminó un {tiempo_vacio_dalto}% de tiempo vacío")

print("---------------------------------------------------------------------------")
#Mostrando diferencias si los cursos duraran 10 horas
este_curso_horas=round(otros_cursos_prom/dalto_curso*10,1)
print(f"Ver 10 horas de este curso equivale a ver {este_curso_horas} horas de otros cursos")

print("---------------------------------------------------------------------------")