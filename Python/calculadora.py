import tkinter as tk
from tkinter import ttk

# --- Credits ---
#  By Fernando Relva
# Date: 23/09/2026

def change(txt):
    if jl.cget("text") == "0.":
        jl.config(text="")
    jl.config(text=jl.cget("text") + txt)


jf = tk.Tk()
jf.title("Calculadora")
jf.geometry("500x700")
jf.resizable(False, False)


jp = tk.Frame(jf, bg="white", highlightbackground="black", highlightthickness=1)
jp.pack(fill="both", expand=True)


jl = tk.Label(
    jp,
    text="0.",
    font=("Arial", 38, "bold"),
    bg="black",
    fg="white",
    anchor="e",  
    highlightbackground="#1E375F",  
    highlightthickness=2,
    padx=10
)
jl.place(x=15, y=15, width=455, height=65)


jl2 = tk.Label(
    jp,
    text="Calculadora by Fernando",
    font=("Arial", 22),
    bg="white",
    fg="black"
)
jl2.place(x=125, y=610, width=300, height=40)


combo_modo = ttk.Combobox(jp, values=["Normal", "Científica"], state="readonly", font=("Arial", 14, "bold"))
combo_modo.set("Normal")
combo_modo.place(x=15, y=90, width=130, height=30)

textos = [
    "1", "2", "3", "4",
    "5", "6", "7", "8",
    "9", "0", "+", "-",
    "X", "/", "=", "."
]

botons = []

for i in range(16):
    txt = textos[i]

    if i == 14:  # Botón '='
        bg_color = "#416EB9"  
    elif i < 10 or i == 15: 
        bg_color = "#FFBE00"  
    else: 
        bg_color = "#F07D2D"  

    # Crear botón
    btn = tk.Button(
        jp,
        text=txt,
        font=("Arial", 34, "bold"),
        fg="white",
        bg=bg_color,
        activebackground=bg_color,
        activeforeground="white",
        relief="flat",
        highlightbackground="#1E375F",  
        highlightthickness=2,
        command=lambda t=txt: change(t)
    )
    botons.append(btn)

botons[0].place(x=25, y=145, width=95, height=95)
botons[1].place(x=155, y=145, width=95, height=95)
botons[2].place(x=285, y=145, width=95, height=95)

botons[3].place(x=25, y=255, width=95, height=95)
botons[4].place(x=155, y=255, width=95, height=95)
botons[5].place(x=285, y=255, width=95, height=95)

botons[6].place(x=25, y=365, width=95, height=95)
botons[7].place(x=155, y=365, width=95, height=95)
botons[8].place(x=285, y=365, width=95, height=95)

botons[9].place(x=25, y=475, width=95, height=95)
botons[15].place(x=155, y=475, width=95, height=95)

botons[10].place(x=410, y=145, width=60, height=60)
botons[11].place(x=410, y=235, width=60, height=60)
botons[12].place(x=410, y=325, width=60, height=60)
botons[13].place(x=410, y=415, width=60, height=60)

botons[14].place(x=410, y=505, width=60, height=60)

linea1 = tk.Frame(jp, bg="black"); linea1.place(x=15, y=130, width=455, height=1)
linea2 = tk.Frame(jp, bg="black"); linea2.place(x=15, y=245, width=375, height=1)
linea3 = tk.Frame(jp, bg="black"); linea3.place(x=15, y=355, width=375, height=1)
linea4 = tk.Frame(jp, bg="black"); linea4.place(x=15, y=465, width=375, height=1)
linea5 = tk.Frame(jp, bg="black"); linea5.place(x=15, y=585, width=455, height=1)

vertical1 = tk.Frame(jp, bg="black"); vertical1.place(x=140, y=130, width=1, height=455)
vertical2 = tk.Frame(jp, bg="black"); vertical2.place(x=270, y=130, width=1, height=455)
vertical3 = tk.Frame(jp, bg="black"); vertical3.place(x=390, y=130, width=1, height=455)

def on_modo_change(event):
    es_normal = combo_modo.get() == "Normal"
    for i in range(10, 15):
        if es_normal:
            botons[i].place(x=410, y=145 + (i - 10) * 90, width=60, height=60)
        else:
            botons[i].place_forget() 
            
    if es_normal:
        vertical3.place(x=390, y=130, width=1, height=455)
    else:
        vertical3.place_forget()

combo_modo.bind("<<ComboboxSelected>>", on_modo_change)

jf.mainloop()