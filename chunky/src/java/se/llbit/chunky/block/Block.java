package se.llbit.chunky.block;

import se.llbit.chunky.entity.Entity;
import se.llbit.chunky.model.TexturedBlockModel;
import se.llbit.chunky.renderer.scene.Scene;
import se.llbit.chunky.resources.Texture;
import se.llbit.chunky.world.Material;
import se.llbit.json.JsonString;
import se.llbit.json.JsonValue;
import se.llbit.math.Ray;
import se.llbit.math.Vector3;
import se.llbit.nbt.CompoundTag;

public abstract class Block extends Material {
  public Block(String name, Texture texture) {
    super(name, texture);
  }

  public boolean intersect(Ray ray, Scene scene) {
    return TexturedBlockModel.intersect(ray, texture);
  }

  @Override public JsonValue toJson() {
    return new JsonString(name);
  }

  public String description() {
    return "";
  }

  @Override public String toString() {
    return name;
  }

  public boolean isBlockEntity() {
    return false;
  }

  public Entity toBlockEntity(Vector3 position, CompoundTag entityTag) {
    throw new Error("This block type can not be converted to a block entity: "
        + getClass().getSimpleName());
  }

  public boolean isEntity() {
    return false;
  }

  public Entity toEntity(Vector3 position) {
    throw new Error("This block type can not be converted to an entity: "
        + getClass().getSimpleName());
  }
}
