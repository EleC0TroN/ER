import string
import linecache

q = input("Block, Item or Tool? b/i/t : ")

settings = open("autom_settings.txt", 'r')

modid = linecache.getline("autom_settings.txt", 1)[:-1]
format = linecache.getline("autom_settings.txt", 2)[:-1]
path = linecache.getline("autom_settings.txt", 3)[:-1]
print("ModID : " + modid)
settings.close()

def add_lang(item):
 lang = open(path + "/assets/" + modid + "/lang/" + format + ".json", "r")
 lines = lang.readlines()
 last_line = len(lang.readlines())
 lang.close()
 del lines[last_line-1]

 new_lang = open(path + "/assets/" + modid + "/lang/" + format + ".json", "w+")
 for line in lines:
  new_lang.write(line)

 if q == "i" or q == "t":
  new_lang.write(' "item.' + modid + '.' + item + '": " "' + "\n}")
 elif q == "b":
  new_lang.write(",")[last_line - 2]
  new_lang.write(' "block.' + modid + '.' + item + '": " "' + "\n}")
 new_lang.close()
 return item

def add_model(item):
 if q == "i":
  model_item = open(path + "/assets/" + modid + "/models/item/" + item + ".json", "tw")
  model_item.write("{\n  \"parent\": \"item/generated\",\n  \"textures\": {\n    \"layer0\": \"" + modid + ":item/" + item + "\"\n  }\n}")
  model_item.close()

 elif q == "b":
  model_block = open(path + "/assets/" + modid + "/models/block/" + item + ".json", "tw")
  model_item = open(path + "/assets/" + modid + "/models/item/" + item + ".json", "tw")
  model_block.write("{\n  \"parent\": \"block/cube_all\",\n  \"textures\": {\n    \"all\": \"" + modid + ":block/" + item + "\"\n  }\n}")
  model_item.write("{\n  \"parent\": \"block/cube_all\",\n  \"textures\": {\n    \"all\": \"" + modid + ":block/" + item + "\"\n  }\n}")
  model_item.close()
  model_block.close()

 elif q == "t":
  model_item = open(path + "/assets/" + modid + "/models/item/" + item + ".json", "tw")
  model_item.write("{\n  \"parent\": \"item/handheld\",\n  \"textures\": {\n    \"layer0\": \"" + modid + ":item/" + item + "\"\n  }\n}")
  model_item.close()
 return item


def add_state(item):
 if q == "b":
  state_block = open(path + "/assets/" + modid + "/blockstates/" + item + ".json", "tw")
  state_block.write("{\n  \"variants\": {\n    \"\": { \"model\": \"" + modid + ":block/" + item + "\" }\n  }\n}")
  state_block.close()
 return item

if q == "i" or q == "t":
 item: string = input("Item : ")
 print("Created item model and lang : " + item)
 add_lang(item)
 add_model(item)
elif q == "b":
 item: string = input("Block : ")
 print("Created block model, lang and states : " + item)
 add_state(item)
 add_model(item)
elif q != "i" and q != "t" and q != "b":
 print("-_-")

q = input("Input anything to finish, sir : ")


